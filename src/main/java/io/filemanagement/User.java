package io.filemanagement;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class User {
  private String id = UUID.randomUUID().toString();
  private String userName;
}
