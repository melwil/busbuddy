/*
 * Copyright 2011 BusBuddy (Roy Sindre Norangshol)
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

package no.norrs.busbuddy.api;

import no.norrs.busbuddy.pub.api.model.ScheduleContainer;
import no.norrs.busbuddy.pub.api.model.StopsContainer;

import java.io.IOException;

/**
 * Roy Sindre Norangshol
 * Date: 8/20/11
 * Time: 5:57 PM
 */
public interface AtbRpController {
    StopsContainer getBusStopsFor(int tripId) throws IOException;

    ScheduleContainer getSchedulesForecast(String locationId) throws IOException;

}
