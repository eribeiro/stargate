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
package io.stargate.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class IndexAdd {
  @NotNull private String table;
  @NotNull private String column;
  private String name;
  private String type;
  private IndexKind kind;

  private boolean ifNotExists = false;

  public void setTable(String table) {
    this.table = table;
  }

  @ApiModelProperty(required = true, value = "Table name")
  public String getTable() {
    return table;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  @ApiModelProperty(required = true, value = "Column name")
  public String getColumn() {
    return column;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ApiModelProperty(value = "The name of the index to add.")
  public String getName() {
    return name;
  }

  public void setIfNotExists(boolean ifNotExists) {
    this.ifNotExists = ifNotExists;
  }

  @ApiModelProperty(
      value =
          "Determines whether to create a new index if an index with the same name exists. Attempting to create an existing index returns an error unless this option is true.")
  public boolean getIfNotExists() {
    return ifNotExists;
  }

  public void setType(String type) {
    this.type = type;
  }

  @ApiModelProperty(value = "A custom index class name or class path.")
  public String getType() {
    return type;
  }

  public void setKind(IndexKind kind) {
    this.kind = kind;
  }

  @JsonProperty("kind")
  @ApiModelProperty(value = "The kind (ENTRIES, KEY, VALUES, FULL) of a index")
  public IndexKind getKind() {
    return kind;
  }
}
