<template>
  <div id="banner">
    <template v-for="(item, key) in bannerVal">
      <router-link v-if="key==0" class="onLink" tag="span" :to="{name : 'homeLink'}" :key="key">{{item}}</router-link>
      <span v-else-if="key==bannerVal.length - 1" class="unfirst last" :key="key">{{item}}</span>
      <router-link v-else class="onLink unfirst" tag="span" :to="{name : 'homeLink'}" :key="key">{{item}}</router-link>
    </template>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: 'Banner',
  props: {
    bannerVal : {
      type : Array,
      required : true
    }
  }
}
</script>

<style scoped>
#banner{
    padding: 20px;
}
#banner span{
  vertical-align: top;
}
.onLink{
  cursor: pointer;
  font-weight: 500;
}
.unfirst{
  background: url('../assets/arrow_right_b.png') no-repeat -2px 0;
  background-size: 21px;
  padding-left: 19px;
}
.onLink:hover{
  color: var(--on-color);
}
.last{
    color: #acacac;
}
</style>
