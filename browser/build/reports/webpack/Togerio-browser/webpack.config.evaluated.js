{
  mode: 'development',
  resolve: {
    modules: [
      '/Users/helicoptera/Desktop/Togerio/build/js/packages/Togerio-browser/kotlin-dce-dev',
      'node_modules'
    ]
  },
  plugins: [
    TeamCityErrorPlugin {}
  ],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: 'style-loader',
            options: {}
          },
          {
            loader: 'css-loader',
            options: {}
          }
        ]
      }
    ]
  },
  entry: {
    main: [
      '/Users/helicoptera/Desktop/Togerio/build/js/packages/Togerio-browser/kotlin-dce-dev/Togerio-browser.js'
    ]
  },
  output: {
    path: '/Users/helicoptera/Desktop/Togerio/browser/build/distributions',
    filename: [Function: filename],
    library: 'browser',
    libraryTarget: 'umd',
    globalObject: 'this'
  },
  devtool: 'eval-source-map',
  stats: {
    warningsFilter: [
      /Failed to parse source map/
    ],
    warnings: false,
    errors: false
  },
  devServer: {
    inline: true,
    lazy: false,
    noInfo: true,
    open: true,
    overlay: false,
    contentBase: [
      '/Users/helicoptera/Desktop/Togerio/browser/build/processedResources/js/main'
    ]
  }
}