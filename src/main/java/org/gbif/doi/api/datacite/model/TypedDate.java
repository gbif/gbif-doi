package org.gbif.doi.api.datacite.model;

import org.gbif.doi.api.datacite.vocabulary.DateType;
import org.gbif.metadata.DateUtils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;

/**
 * Class representing a Date in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class TypedDate implements Serializable {

  public static class Builder {

    private Date startDate;
    // to handle date ranges
    private Date endDate;
    private DateType type;

    public Builder startDate(Date startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder endDate(Date endDate) {
      this.endDate = endDate;
      return this;
    }

    public Builder type(DateType type) {
      this.type = type;
      return this;
    }

    public TypedDate build() {
      return new TypedDate(this);
    }

  }

  public static final DateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -3333304169161362016L;

  private Date startDate;
  // to handle date ranges
  private Date endDate;
  private DateType type;

  public TypedDate() {
  }

  protected TypedDate(Builder builder) {
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.type = builder.type;
  }

  /**
   * If Date is used, dateType is mandatory.
   *
   * @return the type of date
   */
  @NotNull
  public DateType getType() {
    return type;
  }

  public void setType(DateType type) {
    this.type = type;
  }

  /**
   * @return the date relevant to the resource  
   */
  @NotNull
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  /**
   * @return the end date in a date range
   */
  @Nullable
  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  /**
   * Utility to set the date with a textual format
   *
   * @param start to set
   *
   * @throws java.text.ParseException Should it be an erroneous format
   */
  public void setEnd(String start) throws ParseException {
    endDate = DateUtils.calendarDate(start);
  }

  /**
   * Utility to set the date with a textual format
   *
   * @param start To set
   *
   * @throws ParseException Should it be an erroneous format
   */
  public void setStart(String start) throws ParseException {
    startDate = DateUtils.calendarDate(start);
  }

  /**
   * @return formatted RKMS‐ISO860118 standard for depicting date ranges
   */
  public String toRKMSString() {
    return (getStartDate() == null || getEndDate() == null) ? null : String.format("%s/%s", ISO_DATE_FORMAT.format(getStartDate()), ISO_DATE_FORMAT.format(getEndDate()));
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("startDate", startDate)
      .add("endDate", endDate)
      .add("type", type).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(startDate, endDate, type);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof TypedDate) {
      TypedDate that = (TypedDate) object;
      return Objects.equal(this.startDate, that.startDate)
             && Objects.equal(this.endDate, that.endDate)
             && Objects.equal(this.type, that.type);
    }
    return false;
  }
}
