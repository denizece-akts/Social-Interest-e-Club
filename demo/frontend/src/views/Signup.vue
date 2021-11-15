<template>
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
          Create an Account
        </h2>

        <div class="mt-8">
          <div class="text-sm font-bold text-gray-700 tracking-wide text-left">
            Email Address
          </div>
          <input
            class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
            type="email"
            placeholder="example@somemail.com"
            required="required"
            v-model="email"
          />
        </div>

        <div class="mt-8">
          <div class="text-sm font-bold text-gray-700 tracking-wide text-left">
            Username
          </div>
          <input
            class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
            type="text"
            placeholder="super_username"
            required="required"
            v-model="username"
          />
        </div>
        <div class="mt-8">
          <div class="flex justify-between items-center">
            <div class="text-sm font-bold text-gray-700 tracking-wide">
              Password
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
        <div class="mt-8">
          <div class="flex justify-between items-center">
            <div class="text-sm font-bold text-gray-700 tracking-wide">
              Confirm Password
            </div>
          </div>
          <input
            class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
            type="password"
            placeholder="Confirm your password"
            required="required"
            v-model="confirmPassword"
          />
        </div>

        <div class="mt-10">
          <button
              @click="signup"
            class="bg-indigo-500 text-gray-100 p-4 w-full rounded-full tracking-wide
                                font-semibold font-display focus:outline-none focus:shadow-outline hover:bg-indigo-600
                                shadow-lg"
          >
            Sign Up
          </button>
        </div>
      </div>
    </div>
    <div
      class="hidden lg:flex items-center justify-center bg-indigo-100 flex-1 h-screen"
    >
      <div
        class="max-w-xs transform duration-200 hover:scale-110 cursor-pointer"
      >
        <img src="../assets/Add User-amico.svg" alt="" width="700" />
      </div>
    </div>
  </div>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import Axios from "axios";
export default {
  data() {
    return {
      username: "",
      email: "",
      password: "",
      confirmPassword: "",
      isError: false,
    };
  },
  methods: {
    async signup(e){
      e.preventDefault();

      const response = await Axios.post('http://127.0.0.1:8081/api/v1/registration', {
        username : this.username,
        email : this.email,
        password : this.password
      });

      if (response && response.status && response.status === 200){
        alert('User created successfully, please login');
        window.location.href = '/login';
      } else {
        alert('Something went wrong.');
      }

      console.log(response);
    }
  }
}
</script>
