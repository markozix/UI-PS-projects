package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

import main.MainFrame;
import modeli.InformacioniResurs;

public class GenerateScheme implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
//		InformacioniResurs informationResource = ImportInformationResourceAction.loadSoftware("./metascheme.json");
//		;MainFrame.getInstance().getWorkspaceTree().getWorkspace().addInformationResource(informationResource);
		
		ResultSet rs ;
		
		try {

		Statement statemant = MainFrame.getInstance().getConnection().createStatement();
		
		DatabaseMetaData md = MainFrame.getInstance().getConnection().getMetaData();
		rs = md.getTables(null, null, "%", null);
		JSONArray entitiesArray = new JSONArray();
		while (rs.next()) {
			if(!GenerateScheme.bigString.contains(rs.getString(3))) {
				JSONObject tableObject = new JSONObject();
				String tableName = rs.getString(3);
				System.out.println(tableName);
				tableObject.put("name", tableName);
				tableObject.put("path", "");
				
				ResultSet resultSet = statemant.executeQuery("SELECT * from "+tableName );
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				
				JSONArray attributesArray = new JSONArray();
				for(int i=1; i<=columnCount;i++) {
					JSONObject attributeObject = new JSONObject();
					
					attributeObject.put("name", rsmd.getColumnName(i));
					
					if(rsmd.getColumnTypeName(i).equals("int") || rsmd.getColumnTypeName(i).equals("numeric")) {
						attributeObject.put("type", "numeric");
					}
					else {
						attributeObject.put("type", "char");
					}
					
					attributeObject.put("length", 1);
					attributeObject.put("isKey", false);
					attributeObject.put("required", true);
					
					attributesArray.put(attributeObject);
				}
				tableObject.put("atributes", attributesArray);
				JSONArray relationsArrays = new JSONArray();
				tableObject.put("relations", relationsArrays);
				entitiesArray.put(tableObject);
				
			}
		}
		System.out.println(entitiesArray.toString());
		JSONObject res = new JSONObject();
		res.put("name", "Resurs");
		JSONObject pak = new JSONObject();
		pak.put("name", "paket");
		pak.put("entities", entitiesArray);
		res.append("paketi", pak);
		
		File data = new File("Baza.json");
		PrintWriter pw;
		if(!data.exists()) {
			try {
				data.createNewFile();
				pw = new PrintWriter(data);
				pw.write(JsonWriter.formatJson(res.toString()));
				pw.flush();
				pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			try {
				pw = new PrintWriter(data);
				pw.write(JsonWriter.formatJson(res.toString()));
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		}
		} catch (Exception e1) {
		}
	}

	
	static String bigString = "trace_xe_action_map\r\n" + 
			"trace_xe_event_map\r\n" + 
			"CHECK_CONSTRAINTS\r\n" + 
			"COLUMN_DOMAIN_USAGE\r\n" + 
			"COLUMN_PRIVILEGES\r\n" + 
			"COLUMNS\r\n" + 
			"CONSTRAINT_COLUMN_USAGE\r\n" + 
			"CONSTRAINT_TABLE_USAGE\r\n" + 
			"DOMAIN_CONSTRAINTS\r\n" + 
			"DOMAINS\r\n" + 
			"KEY_COLUMN_USAGE\r\n" + 
			"PARAMETERS\r\n" + 
			"REFERENTIAL_CONSTRAINTS\r\n" + 
			"ROUTINE_COLUMNS\r\n" + 
			"ROUTINES\r\n" + 
			"SCHEMATA\r\n" + 
			"SEQUENCES\r\n" + 
			"TABLE_CONSTRAINTS\r\n" + 
			"TABLE_PRIVILEGES\r\n" + 
			"TABLES\r\n" + 
			"VIEW_COLUMN_USAGE\r\n" + 
			"VIEW_TABLE_USAGE\r\n" + 
			"VIEWS\r\n" + 
			"all_columns\r\n" + 
			"all_objects\r\n" + 
			"all_parameters\r\n" + 
			"all_sql_modules\r\n" + 
			"all_views\r\n" + 
			"allocation_units\r\n" + 
			"assemblies\r\n" + 
			"assembly_files\r\n" + 
			"assembly_modules\r\n" + 
			"assembly_references\r\n" + 
			"assembly_types\r\n" + 
			"asymmetric_keys\r\n" + 
			"availability_databases_cluster\r\n" + 
			"availability_group_listener_ip_addresses\r\n" + 
			"availability_group_listeners\r\n" + 
			"availability_groups\r\n" + 
			"availability_groups_cluster\r\n" + 
			"availability_read_only_routing_lists\r\n" + 
			"availability_replicas\r\n" + 
			"backup_devices\r\n" + 
			"certificates\r\n" + 
			"change_tracking_databases\r\n" + 
			"change_tracking_tables\r\n" + 
			"check_constraints\r\n" + 
			"column_store_dictionaries\r\n" + 
			"column_store_segments\r\n" + 
			"column_type_usages\r\n" + 
			"column_xml_schema_collection_usages\r\n" + 
			"columns\r\n" + 
			"computed_columns\r\n" + 
			"configurations\r\n" + 
			"conversation_endpoints\r\n" + 
			"conversation_groups\r\n" + 
			"conversation_priorities\r\n" + 
			"credentials\r\n" + 
			"crypt_properties\r\n" + 
			"cryptographic_providers\r\n" + 
			"data_spaces\r\n" + 
			"database_audit_specification_details\r\n" + 
			"database_audit_specifications\r\n" + 
			"database_files\r\n" + 
			"database_filestream_options\r\n" + 
			"database_mirroring\r\n" + 
			"database_mirroring_endpoints\r\n" + 
			"database_permissions\r\n" + 
			"database_principals\r\n" + 
			"database_recovery_status\r\n" + 
			"database_role_members\r\n" + 
			"databases\r\n" + 
			"default_constraints\r\n" + 
			"destination_data_spaces\r\n" + 
			"dm_audit_actions\r\n" + 
			"dm_audit_class_type_map\r\n" + 
			"dm_broker_activated_tasks\r\n" + 
			"dm_broker_connections\r\n" + 
			"dm_broker_forwarded_messages\r\n" + 
			"dm_broker_queue_monitors\r\n" + 
			"dm_cdc_errors\r\n" + 
			"dm_cdc_log_scan_sessions\r\n" + 
			"dm_clr_appdomains\r\n" + 
			"dm_clr_loaded_assemblies\r\n" + 
			"dm_clr_properties\r\n" + 
			"dm_clr_tasks\r\n" + 
			"dm_cryptographic_provider_properties\r\n" + 
			"dm_database_encryption_keys\r\n" + 
			"dm_db_file_space_usage\r\n" + 
			"dm_db_fts_index_physical_stats\r\n" + 
			"dm_db_index_usage_stats\r\n" + 
			"dm_db_log_space_usage\r\n" + 
			"dm_db_mirroring_auto_page_repair\r\n" + 
			"dm_db_mirroring_connections\r\n" + 
			"dm_db_mirroring_past_actions\r\n" + 
			"dm_db_missing_index_details\r\n" + 
			"dm_db_missing_index_group_stats\r\n" + 
			"dm_db_missing_index_groups\r\n" + 
			"dm_db_partition_stats\r\n" + 
			"dm_db_persisted_sku_features\r\n" + 
			"dm_db_script_level\r\n" + 
			"dm_db_session_space_usage\r\n" + 
			"dm_db_task_space_usage\r\n" + 
			"dm_db_uncontained_entities\r\n" + 
			"dm_exec_background_job_queue\r\n" + 
			"dm_exec_background_job_queue_stats\r\n" + 
			"dm_exec_cached_plans\r\n" + 
			"dm_exec_connections\r\n" + 
			"dm_exec_procedure_stats\r\n" + 
			"dm_exec_query_memory_grants\r\n" + 
			"dm_exec_query_optimizer_info\r\n" + 
			"dm_exec_query_resource_semaphores\r\n" + 
			"dm_exec_query_stats\r\n" + 
			"dm_exec_query_transformation_stats\r\n" + 
			"dm_exec_requests\r\n" + 
			"dm_exec_sessions\r\n" + 
			"dm_exec_trigger_stats\r\n" + 
			"dm_filestream_file_io_handles\r\n" + 
			"dm_filestream_file_io_requests\r\n" + 
			"dm_filestream_non_transacted_handles\r\n" + 
			"dm_fts_active_catalogs\r\n" + 
			"dm_fts_fdhosts\r\n" + 
			"dm_fts_index_population\r\n" + 
			"dm_fts_memory_buffers\r\n" + 
			"dm_fts_memory_pools\r\n" + 
			"dm_fts_outstanding_batches\r\n" + 
			"dm_fts_population_ranges\r\n" + 
			"dm_fts_semantic_similarity_population\r\n" + 
			"dm_hadr_auto_page_repair\r\n" + 
			"dm_hadr_availability_group_states\r\n" + 
			"dm_hadr_availability_replica_cluster_nodes\r\n" + 
			"dm_hadr_availability_replica_cluster_states\r\n" + 
			"dm_hadr_availability_replica_states\r\n" + 
			"dm_hadr_cluster\r\n" + 
			"dm_hadr_cluster_members\r\n" + 
			"dm_hadr_cluster_networks\r\n" + 
			"dm_hadr_database_replica_cluster_states\r\n" + 
			"dm_hadr_database_replica_states\r\n" + 
			"dm_hadr_instance_node_map\r\n" + 
			"dm_hadr_name_id_map\r\n" + 
			"dm_io_backup_tapes\r\n" + 
			"dm_io_cluster_shared_drives\r\n" + 
			"dm_io_pending_io_requests\r\n" + 
			"dm_logpool_hashentries\r\n" + 
			"dm_logpool_stats\r\n" + 
			"dm_os_buffer_descriptors\r\n" + 
			"dm_os_child_instances\r\n" + 
			"dm_os_cluster_nodes\r\n" + 
			"dm_os_cluster_properties\r\n" + 
			"dm_os_dispatcher_pools\r\n" + 
			"dm_os_dispatchers\r\n" + 
			"dm_os_hosts\r\n" + 
			"dm_os_latch_stats\r\n" + 
			"dm_os_loaded_modules\r\n" + 
			"dm_os_memory_allocations\r\n" + 
			"dm_os_memory_broker_clerks\r\n" + 
			"dm_os_memory_brokers\r\n" + 
			"dm_os_memory_cache_clock_hands\r\n" + 
			"dm_os_memory_cache_counters\r\n" + 
			"dm_os_memory_cache_entries\r\n" + 
			"dm_os_memory_cache_hash_tables\r\n" + 
			"dm_os_memory_clerks\r\n" + 
			"dm_os_memory_node_access_stats\r\n" + 
			"dm_os_memory_nodes\r\n" + 
			"dm_os_memory_objects\r\n" + 
			"dm_os_memory_pools\r\n" + 
			"dm_os_nodes\r\n" + 
			"dm_os_performance_counters\r\n" + 
			"dm_os_process_memory\r\n" + 
			"dm_os_ring_buffers\r\n" + 
			"dm_os_schedulers\r\n" + 
			"dm_os_server_diagnostics_log_configurations\r\n" + 
			"dm_os_spinlock_stats\r\n" + 
			"dm_os_stacks\r\n" + 
			"dm_os_sublatches\r\n" + 
			"dm_os_sys_info\r\n" + 
			"dm_os_sys_memory\r\n" + 
			"dm_os_tasks\r\n" + 
			"dm_os_threads\r\n" + 
			"dm_os_virtual_address_dump\r\n" + 
			"dm_os_wait_stats\r\n" + 
			"dm_os_waiting_tasks\r\n" + 
			"dm_os_windows_info\r\n" + 
			"dm_os_worker_local_storage\r\n" + 
			"dm_os_workers\r\n" + 
			"dm_qn_subscriptions\r\n" + 
			"dm_repl_articles\r\n" + 
			"dm_repl_schemas\r\n" + 
			"dm_repl_tranhash\r\n" + 
			"dm_repl_traninfo\r\n" + 
			"dm_resource_governor_configuration\r\n" + 
			"dm_resource_governor_resource_pool_affinity\r\n" + 
			"dm_resource_governor_resource_pools\r\n" + 
			"dm_resource_governor_workload_groups\r\n" + 
			"dm_server_audit_status\r\n" + 
			"dm_server_memory_dumps\r\n" + 
			"dm_server_registry\r\n" + 
			"dm_server_services\r\n" + 
			"dm_tcp_listener_states\r\n" + 
			"dm_tran_active_snapshot_database_transactions\r\n" + 
			"dm_tran_active_transactions\r\n" + 
			"dm_tran_commit_table\r\n" + 
			"dm_tran_current_snapshot\r\n" + 
			"dm_tran_current_transaction\r\n" + 
			"dm_tran_database_transactions\r\n" + 
			"dm_tran_locks\r\n" + 
			"dm_tran_session_transactions\r\n" + 
			"dm_tran_top_version_generators\r\n" + 
			"dm_tran_transactions_snapshot\r\n" + 
			"dm_tran_version_store\r\n" + 
			"dm_xe_map_values\r\n" + 
			"dm_xe_object_columns\r\n" + 
			"dm_xe_objects\r\n" + 
			"dm_xe_packages\r\n" + 
			"dm_xe_session_event_actions\r\n" + 
			"dm_xe_session_events\r\n" + 
			"dm_xe_session_object_columns\r\n" + 
			"dm_xe_session_targets\r\n" + 
			"dm_xe_sessions\r\n" + 
			"endpoint_webmethods\r\n" + 
			"endpoints\r\n" + 
			"event_notification_event_types\r\n" + 
			"event_notifications\r\n" + 
			"events\r\n" + 
			"extended_procedures\r\n" + 
			"extended_properties\r\n" + 
			"filegroups\r\n" + 
			"filetable_system_defined_objects\r\n" + 
			"filetables\r\n" + 
			"foreign_key_columns\r\n" + 
			"foreign_keys\r\n" + 
			"fulltext_catalogs\r\n" + 
			"fulltext_document_types\r\n" + 
			"fulltext_index_catalog_usages\r\n" + 
			"fulltext_index_columns\r\n" + 
			"fulltext_index_fragments\r\n" + 
			"fulltext_indexes\r\n" + 
			"fulltext_languages\r\n" + 
			"fulltext_semantic_language_statistics_database\r\n" + 
			"fulltext_semantic_languages\r\n" + 
			"fulltext_stoplists\r\n" + 
			"fulltext_stopwords\r\n" + 
			"fulltext_system_stopwords\r\n" + 
			"function_order_columns\r\n" + 
			"http_endpoints\r\n" + 
			"identity_columns\r\n" + 
			"index_columns\r\n" + 
			"indexes\r\n" + 
			"internal_tables\r\n" + 
			"key_constraints\r\n" + 
			"key_encryptions\r\n" + 
			"linked_logins\r\n" + 
			"login_token\r\n" + 
			"master_files\r\n" + 
			"master_key_passwords\r\n" + 
			"message_type_xml_schema_collection_usages\r\n" + 
			"messages\r\n" + 
			"module_assembly_usages\r\n" + 
			"numbered_procedure_parameters\r\n" + 
			"numbered_procedures\r\n" + 
			"objects\r\n" + 
			"openkeys\r\n" + 
			"parameter_type_usages\r\n" + 
			"parameter_xml_schema_collection_usages\r\n" + 
			"parameters\r\n" + 
			"partition_functions\r\n" + 
			"partition_parameters\r\n" + 
			"partition_range_values\r\n" + 
			"partition_schemes\r\n" + 
			"partitions\r\n" + 
			"plan_guides\r\n" + 
			"procedures\r\n" + 
			"registered_search_properties\r\n" + 
			"registered_search_property_lists\r\n" + 
			"remote_logins\r\n" + 
			"remote_service_bindings\r\n" + 
			"resource_governor_configuration\r\n" + 
			"resource_governor_resource_pool_affinity\r\n" + 
			"resource_governor_resource_pools\r\n" + 
			"resource_governor_workload_groups\r\n" + 
			"routes\r\n" + 
			"schemas\r\n" + 
			"securable_classes\r\n" + 
			"selective_xml_index_namespaces\r\n" + 
			"selective_xml_index_paths\r\n" + 
			"sequences\r\n" + 
			"server_assembly_modules\r\n" + 
			"server_audit_specification_details\r\n" + 
			"server_audit_specifications\r\n" + 
			"server_audits\r\n" + 
			"server_event_notifications\r\n" + 
			"server_event_session_actions\r\n" + 
			"server_event_session_events\r\n" + 
			"server_event_session_fields\r\n" + 
			"server_event_session_targets\r\n" + 
			"server_event_sessions\r\n" + 
			"server_events\r\n" + 
			"server_file_audits\r\n" + 
			"server_permissions\r\n" + 
			"server_principal_credentials\r\n" + 
			"server_principals\r\n" + 
			"server_role_members\r\n" + 
			"server_sql_modules\r\n" + 
			"server_trigger_events\r\n" + 
			"server_triggers\r\n" + 
			"servers\r\n" + 
			"service_broker_endpoints\r\n" + 
			"service_contract_message_usages\r\n" + 
			"service_contract_usages\r\n" + 
			"service_contracts\r\n" + 
			"service_message_types\r\n" + 
			"service_queue_usages\r\n" + 
			"service_queues\r\n" + 
			"services\r\n" + 
			"soap_endpoints\r\n" + 
			"spatial_index_tessellations\r\n" + 
			"spatial_indexes\r\n" + 
			"spatial_reference_systems\r\n" + 
			"sql_dependencies\r\n" + 
			"sql_expression_dependencies\r\n" + 
			"sql_logins\r\n" + 
			"sql_modules\r\n" + 
			"stats\r\n" + 
			"stats_columns\r\n" + 
			"symmetric_keys\r\n" + 
			"synonyms\r\n" + 
			"syscacheobjects\r\n" + 
			"syscharsets\r\n" + 
			"syscolumns\r\n" + 
			"syscomments\r\n" + 
			"sysconfigures\r\n" + 
			"sysconstraints\r\n" + 
			"syscurconfigs\r\n" + 
			"syscursorcolumns\r\n" + 
			"syscursorrefs\r\n" + 
			"syscursors\r\n" + 
			"syscursortables\r\n" + 
			"sysdatabases\r\n" + 
			"sysdepends\r\n" + 
			"sysdevices\r\n" + 
			"sysfilegroups\r\n" + 
			"sysfiles\r\n" + 
			"sysforeignkeys\r\n" + 
			"sysfulltextcatalogs\r\n" + 
			"sysindexes\r\n" + 
			"sysindexkeys\r\n" + 
			"syslanguages\r\n" + 
			"syslockinfo\r\n" + 
			"syslogins\r\n" + 
			"sysmembers\r\n" + 
			"sysmessages\r\n" + 
			"sysobjects\r\n" + 
			"sysoledbusers\r\n" + 
			"sysopentapes\r\n" + 
			"sysperfinfo\r\n" + 
			"syspermissions\r\n" + 
			"sysprocesses\r\n" + 
			"sysprotects\r\n" + 
			"sysreferences\r\n" + 
			"sysremotelogins\r\n" + 
			"sysservers\r\n" + 
			"system_columns\r\n" + 
			"system_components_surface_area_configuration\r\n" + 
			"system_internals_allocation_units\r\n" + 
			"system_internals_partition_columns\r\n" + 
			"system_internals_partitions\r\n" + 
			"system_objects\r\n" + 
			"system_parameters\r\n" + 
			"system_sql_modules\r\n" + 
			"system_views\r\n" + 
			"systypes\r\n" + 
			"sysusers\r\n" + 
			"table_types\r\n" + 
			"tables\r\n" + 
			"tcp_endpoints\r\n" + 
			"trace_categories\r\n" + 
			"trace_columns\r\n" + 
			"trace_event_bindings\r\n" + 
			"trace_events\r\n" + 
			"trace_subclass_values\r\n" + 
			"traces\r\n" + 
			"transmission_queue\r\n" + 
			"trigger_event_types\r\n" + 
			"trigger_events\r\n" + 
			"triggers\r\n" + 
			"type_assembly_usages\r\n" + 
			"types\r\n" + 
			"user_token\r\n" + 
			"via_endpoints\r\n" + 
			"views\r\n" + 
			"xml_indexes\r\n" + 
			"xml_schema_attributes\r\n" + 
			"xml_schema_collections\r\n" + 
			"xml_schema_component_placements\r\n" + 
			"xml_schema_components\r\n" + 
			"xml_schema_elements\r\n" + 
			"xml_schema_facets\r\n" + 
			"xml_schema_model_groups\r\n" + 
			"xml_schema_namespaces\r\n" + 
			"xml_schema_types\r\n" + 
			"xml_schema_wildcard_namespaces\r\n" + 
			"xml_schema_wildcards" +
			"sysdiagrams";

}
