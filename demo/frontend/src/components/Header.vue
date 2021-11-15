<template>
  <div>
    <template v-if="!hideNavPages.includes($route.path)">
      <div id="nav" class="bg-green-300">
        <!-- LOGGED IN -->
        <template v-if="$store.state.isLoggedIn">
          <div class="absolute right-8 top-4 flex items-center">
            <router-link
              class="flex items-center border-r-2 pr-2 border-black hover:underline"
              :to="`/profile/${user.username}`"
            >
              <img
                class="rounded-full mr-2"
                :src="user.image"
                alt=""
                width="50"
              />
              @{{ user.username }}
            </router-link>
            <button @click="logout" class=" hover:text-red-800  ml-2">
              <i class="fas fa-sign-out-alt text-3xl"></i>
            </button>
          </div>

          <router-link
            to="/club/create"
            v-if="user.isAdmin"
            class="absolute left-8 top-4 flex items-center hover:underline"
            id="create-club-link"
          >
            <i class="fas fa-plus-circle"></i>
            <span class="ml-1">Create Club</span>
          </router-link>

          <router-link to="/">Home</router-link>
        </template>
        <!-- IF NOT -->
        <template v-else>
          <router-link to="/">Guest</router-link> |
          <router-link to="/signup">Sign Up</router-link> |
          <router-link to="/login">Login</router-link>
        </template>
        <h1
          class="text-center text-4xl text-indigo-900 font-display font-semibold lg:text-center xl:text-5xl
                      xl:text-bold padding: 50px"
        >
          Welcome To E-Club!
        </h1>
      </div>
    </template>
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
    if (!user) {
      this.$router.push({ path: "/login" });
      return;
    }

    // TODO: Check admin permission
    this.$store.commit("setUserLoggedIn");
    this.$store.commit("setUser", user);

    return;
  },

  computed: {
    user() {
      return this.$store.state.user;
    },
  },

  methods: {
    logout() {
      this.$cookies.remove("user");
      window.location.reload(true);
    },
  },
};
</script>
<style scoped>
#create-club-link.router-link-exact-active {
  display: none;
}
</style>
