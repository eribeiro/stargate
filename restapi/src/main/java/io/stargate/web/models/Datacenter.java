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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Datacenter {
    String name;
    int replicas;

    public String getName() {
        return name;
    }

    public Datacenter setName(String name) {
        this.name = name;
        return this;
    }

    public int getReplicas() {
        return replicas;
    }

    public Datacenter setReplicas(int replicas) {
        this.replicas = replicas;
        return this;
    }

    @JsonCreator
    public Datacenter(@JsonProperty("name")String name, @JsonProperty("replicas") int replicas) {
        this.name = name;
        this.replicas = replicas;
    }
}