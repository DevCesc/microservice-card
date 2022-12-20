package com.bootcamp.event;

import com.bootcamp.entity.Association;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AssociationCreatedEvent extends Event<Association> {

}
