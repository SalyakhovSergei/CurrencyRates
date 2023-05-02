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
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.RateResponse;
import org.threeten.bp.LocalDate;

/**
 * Список официальных курсов валют на заданную дату, устанавливаемых ежедневно.
 */
@ApiModel(description = "Список официальных курсов валют на заданную дату, устанавливаемых ежедневно.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-07T18:13:29.328552800+10:00[Asia/Vladivostok]")
public class RatesOnDateResponse {
  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private LocalDate date;

  public static final String SERIALIZED_NAME_RATES = "rates";
  @SerializedName(SERIALIZED_NAME_RATES)
  private List<RateResponse> rates = null;


  public RatesOnDateResponse date(LocalDate date) {
    
    this.date = date;
    return this;
  }

   /**
   * Дата установления курса (может отличатся от запрашиваемой если на запрашиваемою дату курс не устанавливался).
   * @return date
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Sun Dec 31 10:00:00 VLAT 2000", value = "Дата установления курса (может отличатся от запрашиваемой если на запрашиваемою дату курс не устанавливался).")

  public LocalDate getDate() {
    return date;
  }


  public void setDate(LocalDate date) {
    this.date = date;
  }


  public RatesOnDateResponse rates(List<RateResponse> rates) {
    
    this.rates = rates;
    return this;
  }

  public RatesOnDateResponse addRatesItem(RateResponse ratesItem) {
    if (this.rates == null) {
      this.rates = new ArrayList<RateResponse>();
    }
    this.rates.add(ratesItem);
    return this;
  }

   /**
   * Список курсов валют.
   * @return rates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Список курсов валют.")

  public List<RateResponse> getRates() {
    return rates;
  }


  public void setRates(List<RateResponse> rates) {
    this.rates = rates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RatesOnDateResponse ratesOnDateResponse = (RatesOnDateResponse) o;
    return Objects.equals(this.date, ratesOnDateResponse.date) &&
        Objects.equals(this.rates, ratesOnDateResponse.rates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, rates);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RatesOnDateResponse {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
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

