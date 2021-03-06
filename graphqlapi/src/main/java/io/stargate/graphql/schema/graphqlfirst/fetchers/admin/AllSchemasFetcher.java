/*
 * Copyright The Stargate Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.stargate.graphql.schema.graphqlfirst.fetchers.admin;

import com.google.common.annotations.VisibleForTesting;
import graphql.schema.DataFetchingEnvironment;
import io.stargate.auth.AuthenticationSubject;
import io.stargate.auth.AuthorizationService;
import io.stargate.db.datastore.DataStore;
import io.stargate.db.datastore.DataStoreFactory;
import io.stargate.graphql.persistence.graphqlfirst.SchemaSource;
import io.stargate.graphql.persistence.graphqlfirst.SchemaSourceDao;
import java.util.List;
import java.util.function.Function;

public class AllSchemasFetcher extends SchemaFetcher<List<SchemaSource>> {
  private final Function<DataStore, SchemaSourceDao> schemaSourceDaoProvider;

  public AllSchemasFetcher(
      AuthorizationService authorizationService, DataStoreFactory dataStoreFactory) {
    this(authorizationService, dataStoreFactory, (SchemaSourceDao::new));
  }

  @VisibleForTesting
  public AllSchemasFetcher(
      AuthorizationService authorizationService,
      DataStoreFactory dataStoreFactory,
      Function<DataStore, SchemaSourceDao> schemaSourceDaoProvider) {
    super(authorizationService, dataStoreFactory);
    this.schemaSourceDaoProvider = schemaSourceDaoProvider;
  }

  @Override
  protected List<SchemaSource> get(
      DataFetchingEnvironment environment,
      DataStore dataStore,
      AuthenticationSubject authenticationSubject)
      throws Exception {
    String keyspace = getKeyspace(environment, dataStore);

    authorize(authenticationSubject, keyspace);

    return schemaSourceDaoProvider.apply(dataStore).getAllVersions(keyspace);
  }
}
