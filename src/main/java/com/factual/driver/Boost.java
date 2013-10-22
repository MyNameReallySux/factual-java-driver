package com.factual.driver;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * The Boost API enables you to signal to Factual that a specific row returned
 * by full-text search in a read API call should be a prominent result for that
 * search.
 * 
 * @author brandon
 */
public class Boost {

  /**
   * @param factualId
   */
  public Boost(String factualId) {
    addParam(Constants.BOOST_FACTUAL_ID, factualId);
  }

  /**
   * 
   * @param factualId
   * @param query
   *          initialize boost from an existing read query.
   */
  public Boost(String factualId, Query query) {
    this(factualId);

    String queryUser = query.user();
    if (queryUser != null)
      user(queryUser);

    String querySearch = query.search();
    if (querySearch != null)
      search(querySearch);

  }

  /**
   * Holds all parameters for this Boost.
   */
  protected final Parameters queryParams = new Parameters();

  /**
   * Full-text-search query parameter value for q from a prior read request.
   * 
   * @param term
   * @return this Boost
   */
  public Boost search(String term) {
    addParam(Constants.SEARCH, term);
    return this;
  }

  /**
   * @param user
   *          An (optional) arbitrary token for correlating boost
   *          requests to a single app/session/etc. Factual does not use this
   *          token to track users. The function of this information is only to
   *          help evaluate how a boost relates to a search.
   * @return this Boost
   */
  public Boost user(String user) {
    addParam(Constants.USER, user);
    return this;
  }

  private Boost addParam(String key, Object value) {
    queryParams.setParam(key, value);
    return this;
  }

  protected Map<String, Object> toUrlParams() {
    return queryParams.toUrlParams(null);
  }

  @Override
  public String toString() {
    try {
      return URLDecoder.decode(UrlUtil.toUrlQuery(toUrlParams()), "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

}