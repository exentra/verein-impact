<template>
  <q-page class="row items-center justify-evenly">
    <TableComponent :invoices="invoices.invoices"></TableComponent>
  </q-page>
</template>

<script lang="ts">
import { Todo, Meta } from 'components/models';
import { defineComponent, ref } from 'vue';
import TableComponent from 'src/components/TableComponent.vue';
import { useInvoicesStore } from 'src/stores/invoices-store';

export default defineComponent({
  name: 'IndexPage',
  components: { TableComponent },
  setup () {
    const invoices = useInvoicesStore();

    return { invoices }
  }
});
</script>
