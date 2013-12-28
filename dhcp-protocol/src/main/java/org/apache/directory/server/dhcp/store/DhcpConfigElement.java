/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.directory.server.dhcp.store;

import java.util.HashMap;
import java.util.Map;

import org.apache.directory.server.dhcp.options.OptionsField;

/**
 * 
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 */
public abstract class DhcpConfigElement {

    public static final String PROPERTY_MAX_LEASE_TIME = "max-lease-time";

    /** List of DhcpOptions for ths subnet */
    private OptionsField options = new OptionsField();

    /** Map of properties for this element */
    private Map properties = new HashMap();

    public OptionsField getOptions() {
        return options;
    }

    public Map getProperties() {
        return properties;
    }
}
