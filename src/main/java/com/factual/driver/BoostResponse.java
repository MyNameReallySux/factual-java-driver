package com.factual.driver;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents the response from running a Boost request against Factual.
 * 
 * @author brandon
 */
public class BoostResponse extends Response {

  public BoostResponse(InternalResponse resp) {
    super(resp);
    try {
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
