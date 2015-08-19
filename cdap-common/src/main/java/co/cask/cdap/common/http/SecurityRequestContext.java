/*
 * Copyright © 2014-2015 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package co.cask.cdap.common.http;

import com.google.common.base.Optional;

/**
 * RequestContext that maintains a ThreadLocal with references to {@code AccessTokenIdentifier}.
 */
public final class SecurityRequestContext {
  private static final ThreadLocal<String> userId = new InheritableThreadLocal<>();

  private SecurityRequestContext() {
  }

  /**
   * @return the userId set on the current thread
   */
  public static Optional<String> getUserId() {
    return Optional.fromNullable(userId.get());
  }

  /**
   * Set the userId on the current thread.
   * @param userIdParam userId to be set
   */
  public static void setUserId(String userIdParam) {
    userId.set(userIdParam);
  }
}
