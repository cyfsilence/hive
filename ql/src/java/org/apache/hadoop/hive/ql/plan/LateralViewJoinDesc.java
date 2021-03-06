/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.plan;

import java.util.ArrayList;
import java.util.Objects;

import org.apache.hadoop.hive.ql.plan.Explain.Level;



/**
 * LateralViewJoinDesc.
 *
 */
@Explain(displayName = "Lateral View Join Operator", explainLevels = { Level.USER, Level.DEFAULT, Level.EXTENDED })
public class LateralViewJoinDesc extends AbstractOperatorDesc {
  private static final long serialVersionUID = 1L;

  private int numSelColumns;
  private ArrayList<String> outputInternalColNames;

  public LateralViewJoinDesc() {
  }

  public LateralViewJoinDesc(int numSelColumns, ArrayList<String> outputInternalColNames) {
    this.numSelColumns = numSelColumns;
    this.outputInternalColNames = outputInternalColNames;
  }

  public void setOutputInternalColNames(ArrayList<String> outputInternalColNames) {
    this.outputInternalColNames = outputInternalColNames;
  }

  @Explain(displayName = "outputColumnNames")
  public ArrayList<String> getOutputInternalColNames() {
    return outputInternalColNames;
  }

  @Explain(displayName = "Output", explainLevels = { Level.USER })
  public ArrayList<String> getUserLevelExplainOutputInternalColNames() {
    return outputInternalColNames;
  }

  public int getNumSelColumns() {
    return numSelColumns;
  }

  public void setNumSelColumns(int numSelColumns) {
    this.numSelColumns = numSelColumns;
  }

  @Override
  public boolean isSame(OperatorDesc other) {
    if (getClass().getName().equals(other.getClass().getName())) {
      LateralViewJoinDesc otherDesc = (LateralViewJoinDesc) other;
      return Objects.equals(getOutputInternalColNames(), otherDesc.getOutputInternalColNames());
    }
    return false;
  }

}
