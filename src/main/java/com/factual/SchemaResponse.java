package com.factual;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Maps;



/**
 * Represents the response from running a schema request against Factual.
 *
 * @author aaron
 */
public class SchemaResponse extends Response {
  private final String json;
  private final Map<String, ColumnSchema> columnSchemas;
  private final String title;
  private final boolean searchEnabled;
  private final boolean geoEnabled;
  private final String description;


  /**
   * Constructor, parses from a JSON response String.
   * 
   * @param json the JSON response String returned by Factual.
   */
  public SchemaResponse(String json) {
    this.json = json;
    try{
      JSONObject rootJsonObj = new JSONObject(json);
      Response.withMeta(this, rootJsonObj);
      JSONObject respObj = rootJsonObj.getJSONObject("response");
      JSONObject view = respObj.getJSONObject("view");

      columnSchemas = makeColumnSchemas(JsonUtil.data(view.getJSONArray("fields")));

      title = view.getString("title");
      description = view.getString("description");
      searchEnabled = view.getBoolean("search_enabled");
      geoEnabled = view.getBoolean("geo_enabled");
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
  }

  private Map<String, ColumnSchema> makeColumnSchemas(List<Map<String, Object>> data) {
    Map<String, ColumnSchema> schemas = Maps.newHashMap();
    for(Map<String, Object> smap : data) {
      schemas.put(smap.get("name").toString(), new ColumnSchema(smap));
    }
    return schemas;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public boolean isSearchEnabled() {
    return searchEnabled;
  }

  public boolean isGeoEnabled() {
    return geoEnabled;
  }

  /**
   * @return The full JSON response from Factual
   */
  @Override
  public String getJson() {
    return json;
  }

  /**
   * @return the size of the schema (that is, the number of columns in the
   *         table)
   */
  public int size() {
    return columnSchemas.size();
  }

  public Map<String, ColumnSchema> getColumnSchemas() {
    return columnSchemas;
  }

  public ColumnSchema getColumnSchema(String columnName) {
    return columnSchemas.get(columnName);
  }

}
