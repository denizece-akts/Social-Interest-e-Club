<template>
  <div>
    <h1 class="font-semibold text-2xl my-2">Enter Club Details</h1>
    <form action="" @submit="createClub">
      <div class="w-3/4 m-auto border border-gray-300 shadow-lg rounded-sm p-4">
        <div class="flex">
          <div class="w-40 text-left">Club Name</div>
          <input
            class="border rounded w-full ml-4"
            type="text"
            minlength="10"
            maxlength="100"
            name=""
            id=""
            placeholder="club name"
            required
          />
        </div>
        <div class="flex my-4">
          <div class="w-40 text-left">Club Description</div>
          <textarea
            class="border rounded w-full ml-4"
            name=""
            minlength="10"
            maxlength="255"
            id=""
            cols="30"
            rows="10"
            placeholder="club description"
            required
          ></textarea>
        </div>
        <div class="flex">
          <div class="w-40 text-left">Club Image</div>
          <input class="border rounded ml-4 w-full" type="file" src="" alt="" />
        </div>
        <button
          class="bg-green-300 text-white px-4 py-2 rounded-md mt-4"
          type="submit"
        >
          Create
        </button>
      </div>
    </form>
  </div>
</template>
<script>
export default {
  methods: {
    createClub(e) {
      e.preventDefault();
      alert("Club Created Successfully");
      this.$router.push({ path: "/club/1235" });
    },
  },
};
</script>
<style>
input,
textarea {
  padding: 0 10px;
}
</style>
