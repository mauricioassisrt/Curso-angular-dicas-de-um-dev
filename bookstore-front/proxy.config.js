const proxy = [
    {
      context: '/api',
      target: 'http://localhost:8000/categorias',
      pathRewrite: {'^/api' : ''}
    }
  ];
  module.exports = proxy;