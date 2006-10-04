/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/


package org.apache.james.jspf.terms;

import org.apache.james.jspf.core.Configurable;
import org.apache.james.jspf.core.Configuration;
import org.apache.james.jspf.core.Modifier;
import org.apache.james.jspf.core.SPF1Data;
import org.apache.james.jspf.exceptions.PermErrorException;
import org.apache.james.jspf.exceptions.TempErrorException;

/**
 * This abstract class represent a gerneric modifier
 * 
 */
public abstract class GenericModifier implements Modifier, Configurable {

    private String host;

    /**
     * @see org.apache.james.jspf.core.Modifier#run(SPF1Data)
     * 
     */
    public abstract String run(SPF1Data spfData) throws PermErrorException,
            TempErrorException;

    /**
     * @see org.apache.james.jspf.core.Configurable#config(Configuration)
     */
    public synchronized void config(Configuration params) throws PermErrorException {
        if (params.groupCount() > 0) {
            this.host = params.group(1);
        }
    }

    /**
     * @return Returns the host.
     */
    protected synchronized String getHost() {
        return host;
    }

}
