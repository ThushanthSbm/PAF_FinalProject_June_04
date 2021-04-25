package main.java.Com;

import main.java.model.Funding_Posts;

import javax.ws.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/FundingPosts")
public class Funding_Post_Services {
	Funding_Posts funding_object=new Funding_Posts();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPosts()
	{
		return funding_object.read_Post();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createPost(
			@FormParam("poststitle") String postsTitle,
			@FormParam("postcontent") String postContent) {
		String output= funding_object.createPost(postsTitle, postContent); //date issue
				return output;
	}
	
	
	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String postData)
	{
		//Convert the input string to a JSON object
		JsonObject postObject = new JsonParser().parse(postData).getAsJsonObject();
		
		String ID = postObject.get("ItemID").getAsString();
		String Title = postObject.get("Title").getAsString();
		String Content = postObject.get("Content").getAsString();

		
		
		String output=funding_object.updatePost(ID, Title, Content);
		
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String item_Data)
	{
		Document doc= Jsoup.parse(item_Data,"",Parser.xmlParser());
		
		String ItemID=doc.select("ItemID").text();
		
		String output=funding_object.deletePost(ItemID);
		return output;
	}
}
