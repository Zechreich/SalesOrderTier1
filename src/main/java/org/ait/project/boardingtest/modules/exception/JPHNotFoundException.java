package org.ait.project.boardingtest.modules.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.boardingtest.config.ModuleException;
import org.ait.project.boardingtest.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHNotFoundException extends ModuleException {

  public JPHNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_POST_NOT_FOUND);
    log.error("JsonPlaceHolder Post not found");
  }
}
