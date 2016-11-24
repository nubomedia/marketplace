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

import org.nubomedia.marketplace.catalogue.utils.IdGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by maa on 28.09.15.
 */
@Entity
public class SupportingService {

  @Id private String id;
  private String name;
  private String osName;
  private String projectId;
  private int replicasNumber;
  private String dockerURL;
  private String route;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Port> ports;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> podList;

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
    this.osName = osName;
    this.dockerURL = dockerURL;
    this.route = route;
    this.ports = ports;
    //    this.targetPorts = targetPorts;

    //    if (ports == null) {
    //      this.ports = targetPorts;
    //    } else {
    //      this.ports = ports;
    //    }

    this.podList = podList;
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

  public String getOsName() {
    return osName;
  }

  public void setOsName(String osName) {
    this.osName = osName;
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

  public List<String> getPodList() {
    return podList;
  }

  public void setPodList(List<String> podList) {
    this.podList = podList;
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

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
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
        + ", osName='"
        + osName
        + '\''
        + ", projectId='"
        + projectId
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
        + ", podList="
        + podList
        + ", envVars="
        + envVars
        + '}';
  }
}
