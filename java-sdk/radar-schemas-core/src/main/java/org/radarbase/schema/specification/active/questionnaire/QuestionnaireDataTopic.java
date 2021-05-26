/*
 * Copyright 2017 King's College London and The Hyve
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.radarbase.schema.specification.active.questionnaire;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URL;
import java.util.Map;
import org.radarbase.schema.specification.DataTopic;

/**
 * TODO.
 */
@JsonInclude(Include.NON_NULL)
public class QuestionnaireDataTopic extends DataTopic {
    @JsonProperty
    private URL questionnaireDefinitionUrl;

    public URL getQuestionnaireDefinitionUrl() {
        return questionnaireDefinitionUrl;
    }

    @Override
    protected void propertiesMap(Map<String, Object> props, boolean reduced) {
        super.propertiesMap(props, reduced);
        props.put("questionnaireDefinitionUrl", questionnaireDefinitionUrl);
    }
}
