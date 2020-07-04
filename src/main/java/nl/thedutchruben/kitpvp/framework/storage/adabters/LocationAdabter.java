package nl.thedutchruben.kitpvp.storage.adabters;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Location;

import java.lang.reflect.Type;
import java.util.Map;

public class LocationAdabter implements JsonSerializer<Location>, JsonDeserializer<Location> {

    @Override
    public Location deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final Type locationType = TypeToken.get(Map.class).getType();
        Map<String, Object> serializedLocation = new Gson().fromJson(jsonElement, locationType);
        return Location.deserialize(serializedLocation);
    }


    @Override
    public JsonElement serialize(Location location, Type type, JsonSerializationContext jsonSerializationContext) {
        return new Gson().toJsonTree(location.serialize()).getAsJsonObject();
    }
}
