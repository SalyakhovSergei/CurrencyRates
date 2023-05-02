/*
 * Axioma OMNI currency rates REST API
 * Получение информации по официальным курсам валют ЦБ и курсам металлов. Промышленный сервис находится по адресу https://, тестовый сервис - по адресу https://ingress-ds1-genr01-fxrt-dev1.apps.ds1-genr01.corp.dev.vtb/fxrates-cbr/v1/api
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: vizgalov@vtb.ru
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.LocalDate;

/**
 * Дата курсов валют ЦБ.
 */
@ApiModel(description = "Дата курсов валют ЦБ.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-07T18:13:29.328552800+10:00[Asia/Vladivostok]")
public class LatestRatesDateResponse {
  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private LocalDate date;


  public LatestRatesDateResponse date(LocalDate date) {
    
    this.date = date;
    return this;
  }

   /**
   * Дата курсов валют.
   * @return date
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Дата курсов валют.")

  public LocalDate getDate() {
    return date;
  }


  public void setDate(LocalDate date) {
    this.date = date;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LatestRatesDateResponse latestRatesDateResponse = (LatestRatesDateResponse) o;
    return Objects.equals(this.date, latestRatesDateResponse.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LatestRatesDateResponse {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
