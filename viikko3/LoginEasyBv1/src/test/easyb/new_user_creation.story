import ohtu.*
import ohtu.services.*
import ohtu.data_access.*
import ohtu.domain.*
import ohtu.io.*

description """A new user account can be created 
              if a proper unused username 
              and a proper password are given"""

scenario "creation successful with correct username and password", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "eero", "sala1nen" ) 
       app = new App(io, auth)
    }
 
    when 'a valid username and password are entered', {
      app.run()
    }

    then 'new user is registered to system', {
      io.getPrints().shouldHave("new user registered")
    }
}

scenario "can login with succesfully generated account", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "eero", "sala1nen", "login", "eero", "sala1nen") 
       app = new App(io, auth)
    }
 
    when 'a valid username and password are entered', {
      app.run()
    }

    then  'new credentials allow logging in to system', {
       io.getPrints().shouldHave("logged in")
    }
}

scenario "creation fails with correct username and too short password", {
    given 'command new user is selected', {
        userDao = new InMemoryUserDao()
        auth = new AuthenticationService(userDao)
        io = new StubIO("new", "eero", "") 
        app = new App(io, auth)
    }

    when 'a valid username and too short password are entered', {
        app.run()
    }

    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
    }
}

scenario "creation fails with correct username and password consisting of letters", {
    given 'command new user is selected', {
        userDao = new InMemoryUserDao()
        auth = new AuthenticationService(userDao)
        io = new StubIO("new", "eero", "jjjj") 
        app = new App(io, auth)
    }

    when 'a valid username and password consisting of letters are entered', {
        app.run()
    }

    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
    }
}

scenario "creation fails with too short username and valid password", {
    given 'command new user is selected', {
        userDao = new InMemoryUserDao()
        auth = new AuthenticationService(userDao)
        io = new StubIO("new", "e", "jjjj3") 
        app = new App(io, auth)
    }

    when 'a too sort username and valid password are entered', {
        app.run()
    }

    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
    }
}

scenario "creation fails with already taken username and valid password", {
    given 'command new user is selected', {
        userDao = new InMemoryUserDao()
        auth = new AuthenticationService(userDao)
        io = new StubIO("new", "pekka", "jjjj3") 
        app = new App(io, auth)
    }

    when 'a already taken username and valid password are entered', {
        app.run()
    }

    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
    }
}

scenario "can not login with account that is not successfully created", {
    given 'command new user is selected', {
        userDao = new InMemoryUserDao()
        auth = new AuthenticationService(userDao)
        io = new StubIO("new", "eero", "jjjj", "login", "eero", "jjjj") 
        app = new App(io, auth)
    }

    when 'a invalid username/password are entered', {
        app.run()
    }

    then  'new credentials do not allow logging in to system', {
        io.getPrints().shouldHave("new user not registered")
        io.getPrints().shouldHave("wrong username or password")
    }

}