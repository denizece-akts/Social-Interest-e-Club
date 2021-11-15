<template>
  <vuetable
    ref="vuetable"
    :api-mode="false"
    :data="tableData"
    :fields="fields"
    pagination-path=""
  >
    <template slot="actions" slot-scope="props">
      <div class="table-button-container">
        <button class="ui button" @click="editRow(props.rowData)">
          <i class="fa fa-edit"></i></button
        >&nbsp;&nbsp;
        <button class="ui basic button ml-4" @click="deleteRow(props.rowData)">
          <i class="fas fa-trash-alt pr-2 text-red-600"></i></button
        >&nbsp;&nbsp;
      </div>
    </template>
  </vuetable>
</template>

<script>
import Vuetable from "vuetable-2";
export default {
  name: "DataTable",
  components: {
    Vuetable,
  },
  props: {
    tableData: {
      type: Array,
      default: () => [],
    },
    fields: {
      type: Array,
      default: () => [],
    },
  },
  methods: {
    editRow(data) {
      console.log({ data }, "edit");
    },
    deleteRow(data) {
      console.log({ data }, "delete");
    },
  },
};
</script>

<style>
tbody,
thead,
tr,
tr {
  border: 1px solid #cecece;
  border-collapse: collapse;
}
tbody > tr:nth-child(odd) {
  background-color: #cecece;
}
tbody > tr:nth-child(even) {
  background-color: #a7a7a7;
}
td,
th {
  padding: 15px;
}
thead > tr {
  background: #1accc3;
  color: white;
}
</style>
