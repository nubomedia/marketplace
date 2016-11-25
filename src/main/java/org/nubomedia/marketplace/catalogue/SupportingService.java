/*
 *
 *  *
 *  *  * (C) Copyright 2016 NUBOMEDIA (http://www.nubomedia.eu)
 *  *  *
 *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  * you may not use this file except in compliance with the License.
 *  *  * You may obtain a copy of the License at
 *  *  *
 *  *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *  *
 *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  * See the License for the specific language governing permissions and
 *  *  * limitations under the License.
 *  *  *
 *  *
 *
 */

package org.nubomedia.marketplace.catalogue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.nubomedia.marketplace.catalogue.utils.IdGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by maa on 28.09.15.
 */
@Entity
public class SupportingService {

  @JsonIgnore @Id private String id;
  private String name;
  private int replicasNumber;
  private String dockerURL;
  private String route;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Port> ports;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<EnvironmentVariable> envVars;

  public SupportingService(
      String name,
      String osName,
      String dockerURL,
      List<Port> ports,
      List<String> podList,
      int replicasNumber,
      String route) {
    this.name = name;
    this.dockerURL = dockerURL;
    this.route = route;
    this.ports = ports;
    //    this.targetPorts = targetPorts;

    //    if (ports == null) {
    //      this.ports = targetPorts;
    //    } else {
    //      this.ports = ports;
    //    }

    //    this.protocols = protocols;
    this.replicasNumber = replicasNumber;
  }

  public SupportingService() {}

  @PrePersist
  public void ensureId() {
    id = IdGenerator.createUUID();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDockerURL() {
    return dockerURL;
  }

  public void setDockerURL(String dockerURL) {
    this.dockerURL = dockerURL;
  }

  public int getReplicasNumber() {
    return replicasNumber;
  }

  public void setReplicasNumber(int replicasNumber) {
    this.replicasNumber = replicasNumber;
  }

  public List<EnvironmentVariable> getEnvVars() {
    return envVars;
  }

  public void setEnvVars(List<EnvironmentVariable> envVars) {
    this.envVars = envVars;
  }

  public List<Port> getPorts() {
    return ports;
  }

  public void setPorts(List<Port> ports) {
    this.ports = ports;
  }

  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  @Override
  public String toString() {
    return "SupportingService{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", replicasNumber="
        + replicasNumber
        + ", dockerURL='"
        + dockerURL
        + '\''
        + ", route='"
        + route
        + '\''
        + ", ports="
        + ports
        + ", envVars="
        + envVars
        + '}';
  }
}
