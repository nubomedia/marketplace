/*
 *
 *  *
 *  *  * (C) Copyright 2016 NUBOMEDIA (http://www.nubomedia.eu)
 *  *  *
 *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  * you may not use this file except in compliance with the License.
 *  *  * You may obtain a copy of the License at
 *  *  *
 *  *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *  *
 *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  * See the License for the specific language governing permissions and
 *  *  * limitations under the License.
 *  *  *
 *  *
 *
 */

package org.nubomedia.marketplace.catalogue.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created by mpa on 17.05.16.
 */
public class IdGenerator {

  private static SecureRandom random = new SecureRandom();

  public static String createId() {
    return new BigInteger(32, random).toString();
  }

  public static String createUUID() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }
}
