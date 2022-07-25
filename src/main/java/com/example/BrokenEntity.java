package com.example;

import io.micronaut.data.annotation.DateUpdated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.jdbc.annotation.ColumnTransformer;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@MappedEntity("account")
public class BrokenEntity {
  public BrokenEntity() {}

  public BrokenEntity(Long id, String field, Instant updated) {
    this.id = id;
    this.field = field;
    this.updated = updated;
  }

  @Id
  @GeneratedValue(GeneratedValue.Type.SEQUENCE)
  Long id;

  /**
   * Specific function doesn't matter, just needs two args with one being substituted
   */
  @NotBlank
  @ColumnTransformer(
      read = "concat(@.field, '${query-value}')",
      write = "concat(?, '${query-value}')")
  String field;

  /**
   * Requires an expandable field to get the commas
   */
  @DateUpdated
  Instant updated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public Instant getUpdated() {
    return updated;
  }

  public void setUpdated(Instant updated) {
    this.updated = updated;
  }
}
