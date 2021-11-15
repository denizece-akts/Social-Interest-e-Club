<template>
  <div>
    <Loading width="70" v-if="isLoggingIn"></Loading>
    <div class="lg:flex">
      <div class="lg:w-1/2 xl:max-w-screen-sm">
        <div
          class="py-12 bg-indigo-100 lg:bg-white flex justify-center lg:justify-start lg:px-12"
        ></div>
        <div
          class="mt-10 px-12 sm:px-24 md:px-48 lg:px-12 lg:mt-16 xl:px-24 xl:max-w-2xl"
        >
          <h2
            class="text-center text-4xl text-indigo-900 font-display font-semibold lg:text-left xl:text-5xl
                    xl:text-bold"
          >
            Login
          </h2>
          <div class="mt-12">
            <form @submit="login">
              <div>
                <div
                  class="text-sm font-bold text-gray-700 tracking-wide text-left"
                >
                  Email Address / ID
                </div>
                <input
                  class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                  type="email|number"
                  placeholder="example@gmail.com / xxxxxx"
                  required="required"
                  v-model="email"
                />
              </div>
              <div class="mt-8">
                <div class="flex justify-between items-center">
                  <div class="text-sm font-bold text-gray-700 tracking-wide">
                    Password
                  </div>
                  <div>
                    <a
                      class="text-xs font-display font-semibold text-indigo-600 hover:text-indigo-800 cursor-pointer"
                    >
                      Forgot Password?
                    </a>
                  </div>
                </div>
                <input
                  class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                  type="password"
                  placeholder="Enter your password"
                  required="required"
                  v-model="password"
                />
              </div>

              <div class="mt-10">
                <button
                  class="bg-indigo-500 text-gray-100 p-4 w-full rounded-full tracking-wide
                                font-semibold font-display focus:outline-none focus:shadow-outline hover:bg-indigo-600
                                shadow-lg"
                >
                  Log In
                </button>
              </div>
            </form>
            <div
              class="mt-12 text-sm font-display font-semibold text-gray-700 text-center"
            >
              Don't have an account ?
              <router-link
                to="/signup"
                class="cursor-pointer text-indigo-600 hover:text-indigo-800"
              >
                Sign Up</router-link
              >
            </div>
          </div>
        </div>
      </div>
      <div
        class="hidden lg:flex items-center justify-center bg-indigo-100 flex-1 h-screen"
      >
        <div
          class="max-w-xs transform duration-200 hover:scale-110 cursor-pointer"
        >
          <img src="../assets/Messaging fun-amico.svg" alt="" width="700" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { setTimeout } from "timers";
import Loading from "@/components/Loading.vue";
import { userInfo } from "os";
export default {
  components: { Loading },
  data() {
    return {
      email: "",
      password: "",
      isLoggingIn: false,
      isAlertShow: false,
    };
  },
  methods: {
    login(e) {
      // it killd default event such as 'submit'
      e.preventDefault();

      this.isLoggingIn = true;

      // api connection will add later
      setTimeout(() => {
        this.isLoggingIn = false;
        // TODO: Console log here for username and password
        console.log(userInfo);
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
        // TODO: Add real JWT
        this.$cookies.set("user", "thisIsSuperFuckinUser");

        this.isAlertShow = true;
        setTimeout(
          () =>
            this.redirect({
              isAdmin: authedUser.isAdmin,
            }),
          1000
        );
      }, 1000);
    },

    redirect(options) {
      this.$router.push({ path: options.isAdmin ? "/admin" : "/home" });
    },
  },
};
</script>
