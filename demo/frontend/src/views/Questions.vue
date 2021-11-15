<template>
  <form @submit="submitForm" class="w-full max-w-lg m-auto">
    <div
      v-for="(q, index) in questions"
      :key="index"
      class="flex rounded-md shadow-lg border border-gray-400 flex-col m-4 p-4"
    >
      <h1 class="text-xl mb-3">{{ q.question }}</h1>
      <label
        v-for="(ans, ansIndex) in q.answers"
        :key="ansIndex"
        class="py-1 hover:bg-gray-100 rounded-sm"
        :for="`question-${index}-answer-${ansIndex}`"
      >
        <input
          class="mr-2"
          required
          type="radio"
          :value="`question-${index}-answer-${ansIndex}`"
          :name="`question-${index}`"
          :id="`question-${index}-answer-${ansIndex}`"
        />
        {{ ans }}
      </label>
    </div>

    <button
      class="px-12 py-2 bg-indigo-500 text-white rounded-lg mb-8"
      type="submit"
    >
      <router-link
        to="/profile/ati"
        class="cursor-pointer text-white-600
      hover:text-white-800"
      >
        Submit
      </router-link>
    </button>
  </form>
</template>
<script>
export default {
  data() {
    return {
      questions: [
        {
          question: "Question 1",
          answers: ["Answer A", "Answer B", "Answer C", "Answer D"],
        },
        {
          question: "Question 2",
          answers: ["Answer A", "Answer B", "Answer C", "Answer D"],
        },
        {
          question: "Question 3",
          answers: ["Answer A", "Answer B", "Answer C", "Answer D"],
        },
        {
          question: "Question 4",
          answers: ["Answer A", "Answer B", "Answer C", "Answer D"],
        },
      ],
    };
  },
  methods: {
    submitForm(e) {
      e.preventDefault();
    },
  },
};
</script>
