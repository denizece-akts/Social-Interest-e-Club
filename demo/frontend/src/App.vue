<template>
  <div id="app">
    <template v-if="!hideNavPages.includes($route.path)">
      <div id="nav" class="bg-green-300">
        <router-link to="/">Guest</router-link> |
        <router-link to="/signup">Sign Up</router-link> |
        <router-link to="/login">Login</router-link>
        <h1
          class="text-center text-4xl text-indigo-900 font-display font-semibold lg:text-center xl:text-5xl
                      xl:text-bold padding: 50px"
        >
          Welcome To E-Club!
        </h1>
      </div>
    </template>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      hideNavPages: ["/admin"],
    };
  },
  beforeCreate() {
    const user = this.$cookies.get("user");
    if (!user) this.$router.push({ path: "/login" });

    const authedUser = {
      userId: 34634773458,
      username: "ati",
      isAdmin: true,
      permissions: ["admin", "god"],
      avatar: "img",
    };
    // TODO: Check admin permission
    this.$store.commit("setUserLoggedIn");
    this.$store.commit("setUser", authedUser);

    return;
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
