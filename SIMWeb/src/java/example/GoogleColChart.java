/*
 * $Id: HelloWorld.template,v 1.2 2008-03-27 05:47:21 ub3rsold4t Exp $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package example;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <code>Set welcome message.</code>
 */
public class GoogleColChart extends ActionSupport {

  private int value1, value2, value3, value4, value5;

  public int getValue1() {
    return value1;
  }

  public void setValue1(int value1) {
    this.value1 = value1;
  }

  public int getValue2() {
    return value2;
  }

  public void setValue2(int value2) {
    this.value2 = value2;
  }

  public int getValue3() {
    return value3;
  }

  public void setValue3(int value3) {
    this.value3 = value3;
  }

  public int getValue4() {
    return value4;
  }

  public void setValue4(int value4) {
    this.value4 = value4;
  }

  public int getValue5() {
    return value5;
  }

  public void setValue5(int value5) {
    this.value5 = value5;
  }

  public String execute() throws Exception {
    setMessage(getText(MESSAGE));
    System.out.println("Google chart");
    return SUCCESS;
  }
  /**
   * Provide default valuie for Message property.
   */
  public static final String MESSAGE = "HelloWorld.message";
  /**
   * Field for Message property.
   */
  private String message;

  /**
   * Return Message property.
   *
   * @return Message property
   */
  public String getMessage() {
    return message;
  }

  /**
   * Set Message property.
   *
   * @param message Text to display on HelloWorld page.
   */
  public void setMessage(String message) {
    this.message = message;
  }

  public String show() {
    LOG.info("\ncol chart show: " + value1 + " " + value2  + " " + value3 + "  " + value4 + " " + value5);
    return "show_chart";
  }
  
   public String input() {
    LOG.info("\ncol chart input: " + value1 + " " + value2  + " " + value3 + "  " + value4 + " " + value5);
    return "input";
  }
}
