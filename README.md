const apps = require("./apps.json");

const getSumSubscriptions = subs =>
  subs && subs.map(s => s.price).reduce((a, b) => a + b, 0);

const filterAppsByCategorie = (categories, name) =>
  categories.some(cat => cat === name);

const filterByAppName = (app, name) => {
  return app => app.name.includes(name);
};

const sortAppsBySumPriceOfSubscriptions = (a, b) => {
  const priceA = getSumSubscriptions(a.subscriptions);
  const priceB = getSumSubscriptions(b.subscriptions);
  if (priceA > priceB) {
    return 1;
  }
  if (priceA < priceB) {
    return -1;
  }
  // a must be equal to b
  return 0;
};

const paginateApp = (apps, page) => {
  const totalPerPage = 3;
  const lastIndex = page * totalPerPage;
  const firstIndex = lastIndex - totalPerPage;
  return apps.slice(firstIndex, lastIndex);
};

const get = (page = 1, appName, categorie) => {
  let result = apps.sort(sortAppsBySumPriceOfSubscriptions);
  if (appName) result = result.filter(app => app.name.includes(appName));
  if (categorie)
    result = result.filter(app =>
      filterAppsByCategorie(app.categories, categorie)
    );
  result = paginateApp(result, page);

  return result;
};

console.log(get(1, "Video", "Productivity"));
