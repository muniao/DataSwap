package org.deta.tinos.string;
import org.json.XML;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.deta.tinos.json.JsonSwap;
import org.deta.tinos.stable.Stable;

import com.google.gson.reflect.TypeToken;
@SuppressWarnings(Stable.SUPPRESS_WARNINGS_DEPRECATION)
public class StringSwap{
	public static String stringToJsonObject(Gson gson, String string){
		return gson.toJson(string);
	}

	public static String stringToXml(Gson gson, String string){
		JSONObject jSONObject= new JSONObject(gson.toJson(string));
		return XML.toString(jSONObject);	
	}

	public static String[] stringToArray(String stopBy, String string){
		String[] strings= string.split(stopBy); 
		return strings;	
	}

	public static List<Object> stringToList(Gson gson, String string
			, String key){
		JSONArray jSONArray= XML.toJSONObject(string).getJSONArray(key);
		List<Object> list= new ArrayList<>();
		for(int i= 0; i< jSONArray.length(); i++){		
			Object object= jSONArray.get(i);
			if(object instanceof JSONObject){
				list.add(new Gson().fromJson(jSONArray
						.getJSONObject(i).toString(), new TypeToken<Map<String
						, Object>>(){}.getType()));
			}else if(object instanceof String){
				list.add(String.valueOf(object));
			}else if(object instanceof JSONArray){
				list.add(JsonSwap.jsonArrayToList(jSONArray.getJSONArray(i)));
			}
		}
		return list;	
	}

	public static Map<String, Object> stringToMap(Gson gson, String string){
		JSONObject jSONObject= new JSONObject(gson.toJson(string));
		return gson.fromJson(jSONObject.toString()
				, new TypeToken<Map<String, Object>>(){}.getType());
	}

	public static String stringToURIencode(String string){
		return java.net.URLEncoder.encode(string);
	}

	public static String uRIencodeToURIdecode(String string){
		return java.net.URLDecoder.decode(string);
	}

	public static int[] stringToCharASCII(String string){
		int[] charASCII= new int[string.length()];
		for(int i= 0; i< string.length(); i++){
			charASCII[i]= string.charAt(i);
		}
		return charASCII;
	}

	public static String charsetSwap(String string,String inputCharset
			, String outputCharset)
					throws UnsupportedEncodingException{
		String output= new String(string.getBytes(inputCharset), outputCharset); 
		return output;
	}

	public static double stringDoubleToDouble(String stringDouble) 
			throws Exception {
		if(stringDouble.toUpperCase().contains(Stable.DOUBLE_INDICATION_NULL)
				|| stringDouble.toUpperCase().contains(Stable
						.DOUBLE_INDICATION_TIVE)) {
			throw new Exception(Stable.INVALID_DOUBLE_FORMAT);
		}
		double output= Double.valueOf(stringDouble);
		return output;
	}

	public static String stringDoubleToBigDecimalRemainder(String stringDouble
			, int newScale) throws Exception {
		if(stringDouble.toUpperCase().contains(Stable.DOUBLE_INDICATION_NULL)
				|| stringDouble.toUpperCase().contains(Stable
						.DOUBLE_INDICATION_TIVE)) {
			throw new Exception(Stable.INVALID_DOUBLE_FORMAT);
		}
		BigDecimal output= new BigDecimal(Double.valueOf(stringDouble))
				.setScale(newScale, BigDecimal.ROUND_HALF_UP);
		return output.toString();
	}
}