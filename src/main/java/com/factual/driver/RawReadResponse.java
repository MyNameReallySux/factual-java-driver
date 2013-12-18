package com.factual.driver;

import org.json.JSONException;
import org.json.JSONObject;

public class RawReadResponse extends Response {

  /**
   * Constructor, parses from a JSON response String.
   */
  public RawReadResponse(InternalResponse resp) {
    super(resp);
    try{
      JSONObject rootJsonObj = new JSONObject(resp.getContent());
      Response.withMeta(this, rootJsonObj);
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String getJson() {
    return resp.getContent();
  }

}
