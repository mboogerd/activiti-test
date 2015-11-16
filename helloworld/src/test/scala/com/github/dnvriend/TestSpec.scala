/*
 * Copyright 2015 Dennis Vriend
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dnvriend

import org.activiti.engine._
import org.scalatest.{ FlatSpec, Matchers }

object Activity {
  /**
   * Single instance of the Activity ProcessEngine
   */
  val processEngine: ProcessEngine = ProcessEngineConfiguration
    .createStandaloneInMemProcessEngineConfiguration().buildProcessEngine()
}

trait TestSpec extends FlatSpec with Matchers {

  /**
    * The runtime service provides an interface to start and query process instances.
    * In addition, process variables can be retrieved and set, and processes
    * can be signaled to leave a wait state.
    */
  val runtimeService: RuntimeService = Activity.processEngine.getRuntimeService

  /**
    * The repository service provides functionality to deploy, query, delete,
    * and retrieve process definitions.
    */
  val repositoryService: RepositoryService = Activity.processEngine.getRepositoryService

  /**
    * The identity service provides an interface on the authentication
    * component of the Activiti process engine.
    */
  val identityService: IdentityService = Activity.processEngine.getIdentityService

  /**
    * With the task service you can do things with user tasks.
    * For example, you can create a new task and query Activiti
    * for a list of tasks that a specific user can claim.
    */
  val taskService: TaskService = Activity.processEngine.getTaskService

  /**
    * To retrieve information about completed process instances
    */
  val historyService: HistoryService = Activity.processEngine.getHistoryService

  /**
    * To work with the user task forms generated by the Activiti form engine
    */
  val formService: FormService = Activity.processEngine.getFormService

  /**
    * The management service can be used to query the Activiti tables and execute jobs.
    */
  val managementService: ManagementService = Activity.processEngine.getManagementService
}
