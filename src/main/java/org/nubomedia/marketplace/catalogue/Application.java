/*
 *
 *  *  Copyright (c) 2015 Technische Universität Berlin
 *  *   Licensed under the Apache License, Version 2.0 (the "License");
 *  *   you may not use this file except in compliance with the License.
 *  *   You may obtain a copy of the License at
 *  *
 *  *          http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *   Unless required by applicable law or agreed to in writing, software
 *  *   distributed under the License is distributed on an "AS IS" BASIS,
 *  *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *   See the License for the specific language governing permissions and
 *  *   limitations under the License.
 *
 */

package org.nubomedia.marketplace.catalogue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.nubomedia.marketplace.catalogue.utils.IdGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

/**
 * Created by mpa on 17.05.16.
 */
@Entity
public class Application {

    @Id
    private String id;

    @JsonIgnore
    @Version
    private int hb_version = 0;

    @NotNull
    private String description;

    @NotNull
    private String provider;

    @ElementCollection
    private Map<String, String> requirements;

    @NotNull
    private String gitURL;

    @NotNull
    private String name;

    @NotNull
    private boolean shared;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<NubomediaPort> ports;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Flavor flavor;

    @Min(1)
    private int replicasNumber;

    private String secretName;

    @Enumerated(EnumType.STRING)
    private QoS qualityOfService;

    private boolean cloudRepository;

    private boolean cdnConnector;

    private boolean turnServerActivate;

    private String turnServerUrl;

    private String turnServerUsername;

    private String turnServerPassword;

    private boolean stunServerActivate;

    private String stunServerIp;

    private String stunServerPort;

    private int scaleInOut;

    private double scale_out_threshold;

    @PrePersist
    public void ensureId(){
        id = IdGenerator.createUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHb_version() {
        return hb_version;
    }

    public void setHb_version(int hb_version) {
        this.hb_version = hb_version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Map<String, String> getRequirements() {
        return requirements;
    }

    public void setRequirements(Map<String, String> requirements) {
        this.requirements = requirements;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public String getGitURL() {
        return gitURL;
    }

    public void setGitURL(String gitURL) {
        this.gitURL = gitURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<NubomediaPort> getPorts() {
        return ports;
    }

    public void setPorts(Set<NubomediaPort> ports) {
        this.ports = ports;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public int getReplicasNumber() {
        return replicasNumber;
    }

    public void setReplicasNumber(int replicasNumber) {
        this.replicasNumber = replicasNumber;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public QoS getQualityOfService() {
        return qualityOfService;
    }

    public void setQualityOfService(QoS qualityOfService) {
        this.qualityOfService = qualityOfService;
    }

    public boolean isCloudRepository() {
        return cloudRepository;
    }

    public void setCloudRepository(boolean cloudRepository) {
        this.cloudRepository = cloudRepository;
    }

    public boolean isTurnServerActivate() {
        return turnServerActivate;
    }

    public void setTurnServerActivate(boolean turnServerActivate) {
        this.turnServerActivate = turnServerActivate;
    }

    public String getTurnServerUrl() {
        return turnServerUrl;
    }

    public void setTurnServerUrl(String turnServerUrl) {
        this.turnServerUrl = turnServerUrl;
    }

    public String getTurnServerUsername() {
        return turnServerUsername;
    }

    public void setTurnServerUsername(String turnServerUsername) {
        this.turnServerUsername = turnServerUsername;
    }

    public String getTurnServerPassword() {
        return turnServerPassword;
    }

    public void setTurnServerPassword(String turnServerPassword) {
        this.turnServerPassword = turnServerPassword;
    }

    public boolean isStunServerActivate() {
        return stunServerActivate;
    }

    public void setStunServerActivate(boolean stunServerActivate) {
        this.stunServerActivate = stunServerActivate;
    }

    public String getStunServerIp() {
        return stunServerIp;
    }

    public void setStunServerIp(String stunServerIp) {
        this.stunServerIp = stunServerIp;
    }

    public String getStunServerPort() {
        return stunServerPort;
    }

    public void setStunServerPort(String stunServerPort) {
        this.stunServerPort = stunServerPort;
    }

    public int getScaleInOut() {
        return scaleInOut;
    }

    public void setScaleInOut(int scaleInOut) {
        this.scaleInOut = scaleInOut;
    }

    public double getScale_out_threshold() {
        return scale_out_threshold;
    }

    public void setScale_out_threshold(double scale_out_threshold) {
        this.scale_out_threshold = scale_out_threshold;
    }

    public boolean isCdnConnector() {
        return cdnConnector;
    }

    public void setCdnConnector(boolean cdnConnector) {
        this.cdnConnector = cdnConnector;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id='" + id + '\'' +
                ", hb_version=" + hb_version +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", requirements=" + requirements +
                ", gitURL='" + gitURL + '\'' +
                ", name='" + name + '\'' +
                ", shared=" + shared +
                ", ports=" + ports +
                ", flavor=" + flavor +
                ", replicasNumber=" + replicasNumber +
                ", secretName='" + secretName + '\'' +
                ", qualityOfService=" + qualityOfService +
                ", cloudRepository=" + cloudRepository +
                ", cdnConnector=" + cdnConnector +
                ", turnServerActivate=" + turnServerActivate +
                ", turnServerUrl='" + turnServerUrl + '\'' +
                ", turnServerUsername='" + turnServerUsername + '\'' +
                ", turnServerPassword='" + turnServerPassword + '\'' +
                ", stunServerActivate=" + stunServerActivate +
                ", stunServerIp='" + stunServerIp + '\'' +
                ", stunServerPort='" + stunServerPort + '\'' +
                ", scaleInOut=" + scaleInOut +
                ", scale_out_threshold=" + scale_out_threshold +
                '}';
    }
}

