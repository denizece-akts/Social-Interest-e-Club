<template>
  <div class="flex my-4 shadow-lg rounded-md">
    <div class="w-1/4">
      <router-link :to="`/club/${club.id}`">
        <img
          class="club-image w-full h-full object-cover rounded-md"
          :src="club.image"
          alt=""
        />
      </router-link>
    </div>
    <div class="w-3/4 px-4 pt-2 pb-4 text-left">
      <router-link :to="`/club/${club.id}`">
        <h2 class="font-bold mb-2 text-2xl hover:underline">
          {{ club.title }}
        </h2>
      </router-link>
      <p>{{ club.description }}</p>
      <div class="user-container flex mt-4">
        <img
          class="rounded-full shadow-xl hover:shadow-2xl"
          :src="
            `https://ui-avatars.com/api/?name=${club.user.name}+${club.user.surname}&background=random&size=64`
          "
          :alt="club.user.username"
          width="50"
        />
        <div class="px-2">
          <h3 class="hover:underline">
            {{ club.user.name + " " + club.user.surname }}
          </h3>
          <span>{{ createDate }}</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },

  props: {
    club: {
      type: Object,
      required: true,
    },
  },

  computed: {
    createDate() {
      const date = this.club.createDate;
      const month = date.toLocaleString("default", {
        month: "short",
        day: "numeric",
      });

      return month;
    },
  },
};
</script>
<style scoped>
.club-image {
  transition: 1s all;
}
.club-image:hover {
  filter: grayscale(50%);
}
</style>
