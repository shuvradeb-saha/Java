package serialization;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.OffsetDateTime;
import java.util.Objects;

public class ObjectMapperTest {

  static class DateTimeTest {
    private OffsetDateTime archiveDate;
    private String stringDate;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      DateTimeTest that = (DateTimeTest) o;
      return Objects.equals(archiveDate, that.archiveDate)
          && Objects.equals(stringDate, that.stringDate);
    }

    @Override
    public int hashCode() {
      return Objects.hash(archiveDate, stringDate);
    }

    @Override
    public String toString() {
      return "DateTimeTest{"
          + "archiveDate="
          + archiveDate
          + ", stringDate='"
          + stringDate
          + '\''
          + '}';
    }

    public OffsetDateTime getArchiveDate() {
      return archiveDate;
    }

    public DateTimeTest setArchiveDate(OffsetDateTime archiveDate) {
      this.archiveDate = archiveDate;
      return this;
    }

    public String getStringDate() {
      return stringDate;
    }

    public void setStringDate(String stringDate) {
      this.stringDate = stringDate;
    }
  }

  private static ObjectMapper getObjectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
    mapper.registerModule(new JavaTimeModule());
    return mapper;
  }

  static class TempClass {
    public String strDate;
    public Object objDate;

    @Override
    public String toString() {
      return "TempClass{" + "strDate='" + strDate + '\'' + ", objDate=" + objDate + '}';
    }
  }

  private static String makeJson(String stringDate, OffsetDateTime objDate)
      throws JsonProcessingException {
    TempClass tmpClass = new TempClass();

    System.out.println("Type in makeJson: " + objDate.getClass().getSimpleName());

    tmpClass.objDate = objDate;
    tmpClass.strDate = stringDate;

    return getObjectMapper().writeValueAsString(tmpClass);
  }

  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = getObjectMapper();
    DateTimeTest dt = new DateTimeTest();

    dt.setArchiveDate(OffsetDateTime.parse("2022-03-24T04:01:09.000Z"))
        .setStringDate("2022-03-24T04:01:09.000Z");

    // String JSON = mapper.writeValueAsString(dt);
    String JSON = makeJson(dt.getStringDate(), dt.getArchiveDate());
    System.out.println("JSON: \n" + JSON);

    TempClass newDt = mapper.readValue(JSON, TempClass.class);
    System.out.println(newDt.toString());

    DateTimeTest newDtTest = new DateTimeTest();
    System.out.println("Type: " + newDt.objDate.getClass().getSimpleName());
  }
}
