'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

// API地址
module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  BASE_API: '"http://localhost:1001"'
})
