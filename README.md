# PlayerProfileAPI 

This API is useful for people who are creating skull-arts. 
You can use the build in command `/playerprofile <uuid>` or use the API. 

# API 

You can access the API by calling the ``.getInstance()`` method in the PlayerProfileApi class. 
Now you can access the method ``void getPlayerProfile(UUID uuid, Consumer<Optional<PlayerProfile>> playerProfile);`` 
you make a call to the official Mojang API (asynchronously) and receive a ``PlayerProfile`` with the skin data.
