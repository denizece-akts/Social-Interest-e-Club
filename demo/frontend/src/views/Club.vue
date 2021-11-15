<template>
  <div class="flex">
    <div class="w-1/4 border-r-2 border-black mt-4 mb-8">
      <div class="flex flex-col items-center px-4">
        <img
          class="rounded-xl shadow-xl"
          src="https://pinchofyum.com/wp-content/uploads/Cashew-Coffee-Recipe.jpg"
          width="150"
        />
        <h1 class="font-semibold text-2xl mt-4 mb-1">{{ "Coffee Club" }}</h1>
        <div class="text-gray-500 text-sm text-left">
          {{ club.description }}
        </div>
        <div class="mt-4 border border-gray-900 w-full">
          <h2 class="font-semibold border-b-2 border-black py-2">
            Member List
          </h2>
          <div>
            <div
              v-for="(user, index) in club.members"
              :key="index"
              class="flex items-center mb-1 border-b border-gray-200 mx-2 py-1"
            >
              <img
                :src="getUserAvatar(user.username)"
                alt=""
                width="35"
                class="rounded-full mr-3"
              />
              <span>{{ user.username }}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="w-3/4 px-8 mb-8">
      <ClubCard v-for="(club, index) in posts" :key="index" :club="club" />
    </div>
  </div>
</template>
<script>
import ClubCard from "@/components/ClubCard";
import { getUserAvatar } from "@/helper";
export default {
  components: {
    ClubCard,
  },
  data() {
    return {
      club: {
        name: "Coffee Questions",
        description: "What is your favorite brewing technique",
        members: [
          {
            username: "berkan",
          },
          {
            username: "ati",
          },
          {
            username: "deniz",
          },
          {
            username: "ayca",
          },
          {
            username: "volkan",
          },
        ],
      },

      posts: [
        {
          id: "1235",
          title: "Espresso",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus quia, nulla! Maiores et perferendis eaque, exercitationem praesentium nihil.",
          image:
            "https://pinchofyum.com/wp-content/uploads/Cashew-Coffee-Recipe.jpg",
          createDate: new Date(),
          user: {
            name: "Atakan",
            surname: "S",
            username: "selamBenAti",
            bio: "Frontend-Developer @powerpuff-girls inc.",
          },
        },
        {
          id: "1235",
          title: "Latte",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus quia, nulla! Maiores et perferendis eaque, exercitationem praesentium nihil.",
          image:
            "https://pinchofyum.com/wp-content/uploads/Cashew-Coffee-Recipe.jpg",
          createDate: new Date(),
          user: {
            name: "Atakan",
            surname: "S",
            username: "selamBenAti",
            bio: "Frontend-Developer @powerpuff-girls inc.",
          },
        },
        {
          id: "1235",
          title: "Mocha",
          description:
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus quia, nulla! Maiores et perferendis eaque, exercitationem praesentium nihil.",
          image:
            "https://pinchofyum.com/wp-content/uploads/Cashew-Coffee-Recipe.jpg",
          createDate: new Date(),
          user: {
            name: "Atakan",
            surname: "S",
            username: "selamBenAti",
            bio: "Frontend-Developer @powerpuff-girls inc.",
          },
        },
      ],
    };
  },

  methods: {
    getUserAvatar(name, surname) {
      return getUserAvatar(name, surname);
    },
  },
};
</script>
