<template>
  <q-page class="row items-center justify-evenly">
    <q-file
      filled
      bottom-slots
      label="Invoice"
      counter
      clearable
      @update:model-value="file => handleFile(file)"
      @clear="invoice.setImage(null)"
    >
      <template v-slot:prepend>
        <q-icon name="cloud_upload" @click.stop.prevent />
      </template>
      <template v-slot:append>
        <q-icon name="close" @click="invoice.setImage(null)" class="cursor-pointer" />
      </template>

      <template v-slot:hint>
        Take or select an image of your invoice
      </template>
    </q-file>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { useInvoiceStore } from 'src/stores/invoice-store';

const INVOICE_DETECT_URL = process.env.VUA_APP_INVOICE_DETECT_URL

async function readFileToBase64(file: File): Promise<string> {
  return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = function () {
        resolve(reader.result.toString())
      };
      reader.onerror = function (error) {
        reject(error);
      };
  })
}

export default defineComponent({
  name: 'ScanPage',
  components: {  },
  setup () {
    const invoice = useInvoiceStore();
    return { invoice };
  },
  methods: {
    async handleFile(file: File) {
      const base64 = await readFileToBase64(file);
      this.invoice.setImage(base64);

      try {
        const res = await fetch(INVOICE_DETECT_URL, {
          method: 'POST',
          headers: {
            'content-type': 'application/json'
          },
          body: JSON.stringify({
            image: base64,
          }),
        })
        const analysis = await res.json()
        this.invoice.setContents(analysis)
      } catch(e) {
        console.error(e)
        this.invoice.setContents(null)
      }

      this.$router.push('/create')
    }
  }
});
</script>
