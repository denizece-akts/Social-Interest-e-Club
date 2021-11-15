<template>
  <div>
    <div id="nav" class="home">
      <h1
        class="text-center text-large text-indigo-900 font-display font-semibold lg:text-center xl:text-2xl
                    xl:text-bold padding-top:50px"
      >
        You can search clubs as a guest.
      </h1>
      <div
        id="nav"
        class="pt-2 relative mx-auto text-gray-600 flex items-center justify-center"
      >
        <input
          class="border-2 border-gray-300 bg-white h-10 px-4 rounded-lg text-sm focus:outline-none w-full max-w-xs"
          type="search"
          name="search"
          placeholder="Search"
        />
        <button type="submit" class="ml-4 text-2xl text-green-400">
          <i class="fas fa-search"></i>
        </button>
      </div>
    </div>

    <!-- <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  </div>
</template>

<style>
#nav {
  padding-top: 50px;
}

#search {
  padding: 30px;
}
</style>

<script>
// // @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

// export default {
//   name: 'Home',
//   components: {
//     HelloWorld
//   }
// }
</script>
