let menuTabs = document.querySelector(".menu-tabs");
menuTabs.addEventListener("click", function (change) {
  // If clicked tab does not contains active class
  if (
    change.target.classList.contains("menu-tab-item") &&
    !change.target.classList.contains("active")
  ) {
    // gets the data attribute
    const target = change.target.getAttribute("data-target");

    // Remove active class from active tab
    menuTabs.querySelector(".active").classList.remove("active");

    // Add active class from clicked tab
    change.target.classList.add("active");

    let menuSection = document.querySelector(".menu-section");

    // Remove show class from Active Tab Content
    menuSection
      .querySelector(".menu-tab-content.show")
      .classList.remove("show");

    // Add show class to clicked Tab Content
    menuSection.querySelector(target).classList.add("show");
  }
  // If clicked tab contains active class
  else {
    return; // return nothing
  }
});
