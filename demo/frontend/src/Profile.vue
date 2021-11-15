<template>
  <div class="h-full" :class="{ loading: !user.username }">
    <div v-if="user.username" class="flex">
      <div class="w-1/4 border-r-2 border-black mt-4">
        <div class="flex flex-col items-center px-2">
          <img
            class="rounded-xl shadow-xl"
            :src="
              `https://ui-avatars.com/api/?name=${user.name}+${user.surname}&background=random&size=128`
            "
            :alt="user.username"
          />
          <span class="my-3 text-gray-400 hover:underline"
            >@{{ user.username }}</span
          >
          <div class="font-bold">{{ user.name + " " + user.surname }}</div>
          <div class="my-3 italic">{{ user.bio }}</div>
        </div>
      </div>
      <div class="w-3/4 px-8 mb-8">
        <ClubCard v-for="(club, index) in clubs" :key="index" :club="club" />
      </div>
    </div>
    <div v-else class="relative h-full">
      <Loading width="200" />
    </div>
  </div>
</template>
<script>
import ClubCard from "@/components/ClubCard";
import Loading from "@/components/Loading";
export default {
  components: {
    ClubCard,
    Loading,
  },
  data() {
    return {
      user: {},
      clubs: [],
    };
  },

  async created() {
    console.info(this.$route.params);
    // TODO: Connect To API
    // const response = await this.$http.get("http://127.0.0.1:8081/api/v1/user", {
    //   params: {
    //     username: this.$route.params,
    //   }
    // });
    // response.data.user
    let that = this;
    setTimeout(() => {
      that.user = {
        name: "Atakan",
        surname: "Ak",
        username: "selamBenAti",
        bio: "Frontend-Developer @powerpuff-girls inc.",
      };
      // response.data.user.clubs ?
      that.clubs = [
        {
          id: "1235",
          title: "Coffee Club",
          description:
            "Welcome to Coffee Club! We talk about our favorite types of coffee here.",
          image:
            "https://pinchofyum.com/wp-content/uploads/Cashew-Coffee-Recipe.jpg",
          createDate: new Date(),
          user: {
            name: "Deniz Ece",
            surname: "Aktaş",
            username: "denizece",
            bio: "Frontend-Developer @powerpuff-girls inc.",
          },
        },

        {
          id: "1235",
          title: "Cyber Security Club",
          description:
            "If you like hacking and encryption, this is the club for you!",
          image:
            "https://pinchofyum.com/wp-content/uploads/Cashew-Coffee-Recipe.jpg",
          createDate: new Date(),
          user: {
            name: "Volkan",
            surname: "Erciyas",
            username: "volkanerciyas",
            bio: "Backend-Developer @powerpuff-girls inc.",
          },
        },
        {
          id: "1235",
          title: "Anime Club",
          description:
            "We love to watch and talk about anime in this club. Join us today!",
          image:
            "https://pinchofyum.com/wp-content/uploads/Cashew-Coffee-Recipe.jpg",
          createDate: new Date(),
          user: {
            name: "Ayça",
            surname: "Coşkun",
            username: "ayçaçoşkun",
            bio: "Backend-Developer @powerpuff-girls inc.",
          },
        },
      ];
    }, 1000);
  },
};
</script>
<style>
html,
body,
#app {
  height: 100%;
}

.loading {
  height: calc(100% - 144px);
}
</style>
