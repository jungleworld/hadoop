/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.api.records.impl.pb;

import org.apache.hadoop.yarn.api.records.ContainerId;
import org.apache.hadoop.yarn.api.records.ContainerResourceIncreaseRequest;
import org.apache.hadoop.yarn.api.records.Resource;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerIdProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerResourceIncreaseRequestProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerResourceIncreaseRequestProtoOrBuilder;
import org.apache.hadoop.yarn.proto.YarnProtos.ResourceProto;

@Deprecated
public class ContainerResourceIncreaseRequestPBImpl extends
    ContainerResourceIncreaseRequest {
  ContainerResourceIncreaseRequestProto proto =
      ContainerResourceIncreaseRequestProto.getDefaultInstance();
  ContainerResourceIncreaseRequestProto.Builder builder = null;
  boolean viaProto = false;

  private ContainerId existingContainerId = null;
  private Resource targetCapability = null;

  public ContainerResourceIncreaseRequestPBImpl() {
    builder = ContainerResourceIncreaseRequestProto.newBuilder();
  }

  public ContainerResourceIncreaseRequestPBImpl(
      ContainerResourceIncreaseRequestProto proto) {
    this.proto = proto;
    viaProto = true;
  }

  public ContainerResourceIncreaseRequestProto getProto() {
    mergeLocalToProto();
    proto = viaProto ? proto : builder.build();
    viaProto = true;
    return proto;
  }

  @Override
  public ContainerId getContainerId() {
    ContainerResourceIncreaseRequestProtoOrBuilder p = viaProto ? proto
        : builder;
    if (this.existingContainerId != null) {
      return this.existingContainerId;
    }
    if (p.hasContainerId()) {
      this.existingContainerId = convertFromProtoFormat(p.getContainerId());
    }
    return this.existingContainerId;
  }

  @Override
  public void setContainerId(ContainerId existingContainerId) {
    maybeInitBuilder();
    if (existingContainerId == null) {
      builder.clearContainerId();
    }
    this.existingContainerId = existingContainerId;
  }

  @Override
  public Resource getCapability() {
    ContainerResourceIncreaseRequestProtoOrBuilder p = viaProto ? proto
        : builder;
    if (this.targetCapability != null) {
      return this.targetCapability;
    }
    if (p.hasCapability()) {
      this.targetCapability = convertFromProtoFormat(p.getCapability());
    }
    return this.targetCapability;
  }

  @Override
  public void setCapability(Resource targetCapability) {
    maybeInitBuilder();
    if (targetCapability == null) {
      builder.clearCapability();
    }
    this.targetCapability = targetCapability;
  }

  private ContainerIdPBImpl convertFromProtoFormat(ContainerIdProto p) {
    return new ContainerIdPBImpl(p);
  }

  private ContainerIdProto convertToProtoFormat(ContainerId t) {
    return ((ContainerIdPBImpl) t).getProto();
  }

  private Resource convertFromProtoFormat(ResourceProto p) {
    return new ResourcePBImpl(p);
  }

  private ResourceProto convertToProtoFormat(Resource t) {
    return ProtoUtils.convertToProtoFormat(t);
  }

  private void mergeLocalToProto() {
    if (viaProto) {
      maybeInitBuilder();
    }
    mergeLocalToBuilder();
    proto = builder.build();
    viaProto = true;
  }

  private void maybeInitBuilder() {
    if (viaProto || builder == null) {
      builder = ContainerResourceIncreaseRequestProto.newBuilder(proto);
    }
    viaProto = false;
  }

  private void mergeLocalToBuilder() {
    if (this.existingContainerId != null) {
      builder.setContainerId(convertToProtoFormat(this.existingContainerId));
    }
    if (this.targetCapability != null) {
      builder.setCapability(convertToProtoFormat(this.targetCapability));
    }
  }
}