<#--
/*
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
-->
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
<script type='text/javascript'>
jQuery(document).ready(function () { 
 <#-- 
 /*
 * There's a big performance issue when using the main DataTable.js in minified version (the official min from the dist ! )
 * with other plugins such as responsive, and in some browser ( Firefox ) 
 * Must investigate ... Disabling minified version until a solution is found (try build our custom min version of Datatables)
 *
 *  jQuery.struts2_jquery.require(["js/struts2/jquery.datatables.struts2"+jQuery.struts2_jquery.minSuffix+".js","js/plugins/jquery.dataTables"+jQuery.struts2_jquery.minSuffix+".js"]);
 });
 *
 */
 -->
    jQuery.struts2_jquery.require(["js/struts2/jquery.datatables.struts2"+jQuery.struts2_jquery.minSuffix+".js","js/plugins/jquery.dataTables.js"]);
 });
</script>
<table id="${parameters.id?html}" 
<#if parameters.cssClass??>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
>
